# wf-springcloud
# jwt

请求流程：
1.先登录，获取token
Post : http://localhost:8080/login

`{
    "code": "0",
    "msg": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.lW009AUlKkqudlfwULo3sfasGzy_DPDx51Ncnb8ST30",
    "desc": null,
    "signType": null,
    "signature": null,
    "timestamp": "1593309191918",
    "data": null
}`

****2.携带token访问其他接口****
get: http://localhost:8080/get

`{
    "code": "0",
    "msg": "成功",
    "desc": null,
    "signType": null,
    "signature": null,
    "timestamp": "1593309468871",
    "data": null
}`
