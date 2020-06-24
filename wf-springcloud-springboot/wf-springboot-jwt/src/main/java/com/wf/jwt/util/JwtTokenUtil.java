package com.wf.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wf.common.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author ：wf
 * @Date ：2020/6/23 14:01
 * @Describe：token生成工具
 */
@Component
public class JwtTokenUtil {
    static final long EXPIRATIONTIME = 432_000_000;     // 5天
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key
    static final String SECRET = "P@ssw02d";            // JWT密码
    /**
     * 根据用户信息生成token
     * @param sysUser
     * @return
     */
    public String getToken(User sysUser) {
        String token="";
        token= JWT.create().withAudience(sysUser.getUserId().toString())// id 保存到 token 里面
                .sign(Algorithm.HMAC256(sysUser.getPwd()));// password 作为 token 的密钥
        return token;
    }

    /**
     * 根据用户信息生成token
     * <p>
     * 格式为XXXX.XXXX.XXXX的字符串
     * JWT由3个子字符串组成，分别为Header，Payload以及Signature，结合JWT的格式即：Header.Payload.Signature。（Claim是描述Json的信息的一个Json，将Claim转码之后生成Payload）。
     * <p>
     * Header：
     * Header是由以下这个格式的Json通过Base64编码（编码不是加密，是可以通过反编码的方式获取到这个原来的Json，
     * 所以JWT中存放的一般是不敏感的信息）生成的字符串，Header中存放的内容是说明编码对象是一个JWT以及使用“SHA-256”的算法进行加密（加密用于生成Signature）
     * <p>
     * {
     * "typ":"JWT",
     * "alg":"HS256"
     * }
     * <p>
     * Claim是一个Json，Claim中存放的内容是JWT自身的标准属性，所有的标准属性都是可选的，可以自行添加，比如：JWT的签发者、JWT的接收者、
     * JWT的持续时间等；同时Claim中也可以存放一些自定义的属性，这个自定义的属性就是在用户认证中用于标明用户身份的一个属性，
     * 比如用户存放在数据库中的id，为了安全起见，一般不会将用户名及密码这类敏感的信息存放在Claim中。
     * 将Claim通过Base64转码之后生成的一串字符串称作Payload。
     * <p>
     * {
     * "iss":"Issuer —— 用于说明该JWT是由谁签发的",
     * "sub":"Subject —— 用于说明该JWT面向的对象",
     * "aud":"Audience —— 用于说明该JWT发送给的用户",
     * "exp":"Expiration Time —— 数字类型，说明该JWT过期的时间",
     * "nbf":"Not Before —— 数字类型，说明在该时间之前JWT不能被接受与处理",
     * "iat":"Issued At —— 数字类型，说明该JWT何时被签发",
     * "jti":"JWT ID —— 说明标明JWT的唯一ID",
     * "user-definde1":"自定义属性举例",
     * "user-definde2":"自定义属性举例"
     * }
     * Signature
     * <p>
     * Signature是由Header和Payload组合而成，将Header和Claim这两个Json分别使用Base64方式进行编码，生成字符串Header和Payload，
     * 然后将Header和Payload以Header.Payload的格式组合在一起形成一个字符串，然后使用上面定义好的加密算法和一个密匙
     * （这个密匙存放在服务器上，用于进行验证）对这个字符串进行加密，形成一个新的字符串，这个字符串就是Signature。
     *
     * @param user
     * @return
     */
    public static String getToken1(User user) {
        // 生成JWT
        String JWT = Jwts.builder()
                // 用户名写入标题
                .setSubject(user.getUserId().toString())
                // 有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, user.getPwd())
                .compact();


        return JWT;
    }

    /**
     * 分割token
     * token 一共分为三段
     *
     * @param token
     * @return
     * @throws Exception
     */
    static String[] splitToken(String token) throws Exception {
        String[] parts = token.split("\\.");
        if (parts.length == 2 && token.endsWith(".")) {
            parts = new String[]{parts[0], parts[1], ""};
        }
        if (parts.length != 3) {
            throw new Exception(String.format("The token was expected to have 3 parts, but got %s.", parts.length));
        } else {
            return parts;
        }
    }

    // JWT验证方法
    public static String getAuthentication(String token, User user) throws Exception {
        // 获取 token 中的 用户id
        String userId;
        if (token != null) {
            try {
                //验证token
                Claims claims = Jwts.parser()
                        // 验签
                        .setSigningKey(user.getPwd())
                        // 去掉 Bearer
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();
                // 拿用户名
                userId = claims.getSubject();
            } catch (Exception e) {
                throw new Exception("非法token，请检查");
            }
            System.out.println("userId: " + userId);
            // 返回验证令牌
            return userId;
        }
        return null;
    }

    public static void main(String[] args) {


        User user1 = new User();
        user1.setUserId(1234567890);
        user1.setPwd("222222");
        String token = JwtTokenUtil.getToken1(user1);
        System.out.println("" + token);
        try {
            String str[] = splitToken(token);

            System.out.println(str[2]);

            getAuthentication(token, user1);


            String headerJson = StringUtils.newStringUtf8(Base64.decodeBase64(str[0]));
            String remark = String.format("headerJson为%s", headerJson);

            System.out.println("headerJson: " + remark);

            String payloadJson = StringUtils.newStringUtf8(Base64.decodeBase64(str[1]));
            System.out.println("payloadJson: " + payloadJson);

            String signature = StringUtils.newStringUtf8(Base64.decodeBase64(str[2]));
            System.out.println("signature: " + signature);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
