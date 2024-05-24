# API Reference

## /all/users
すべてのユーザーを読み取る

### example
要求URL: http://localhost/all/users

応答: 
```json
[
    {
        "user_id": 1,
        "username": "WangPeiJun",
        "password": "e10adc3949ba59abbe56e057f20f883e"
    },
    {
        "user_id": 2,
        "username": "Madono Mio",
        "password": "508df4cb2f4d8f80519256258cfb975f"
    },
    {
        "user_id": 3,
        "username": "Yamashita Shizuki",
        "password": "$2a$10$UB2JYazJGm6kLdUfjrerdOgdohyOcDqDqF1Q6vSFp5jzQmiybbkSy"
    },
    {
        "user_id": 4,
        "username": "Taniguchi Airi",
        "password": "$2a$10$vnplq1i.4Rcxf7CjO4Ad5.nSg2IfWggET/8STZ.NfhuCNeakGzxe6"
    },
    {
        "user_id": 5,
        "username": "Ishimori Rika",
        "password": "$2a$10$QFI20J65J/GpOIxo9Agb1.3tZ6SuzzGU14aXQs54aWRiAbfFN26za"
    },
    {
        "user_id": 6,
        "username": "Endo Riko",
        "password": "$2a$10$CVkKx03paObC8UPMK5WoVeeoeThHwoeQUxLluBqRy.Rj5HnjYOnOq"
    },
    {
        "user_id": 7,
        "username": "Odakura Reina",
        "password": "$2a$10$ZXKDoMtn9tFntBjcPx71gesF8FePmiGomg5y4WnSEpiS9cToVeoPK"
    },
    {
        "user_id": 8,
        "username": "Murai Yu",
        "password": "$2a$10$mZQFBnNTDbyWEMDYAAyQD.SjVZq3CWdZ4p6FQUY5ZvPya3jATGNFS"
    },
    {
        "user_id": 9,
        "username": "Mukai Itoha",
        "password": "$2a$10$D0V8AWfUIlNOIoUjkp4Y4u5wsXdUnVIx2nFxLzCQ9E86lYkUblj/K"
    },
    {
        "user_id": 10,
        "username": "Murayama Miyu",
        "password": "$2a$10$vbpmlkd/pFlVX1zELb7uuedEdidl05Yqvcmre5jx0ui0QVnSiuMpO"
    }
]
```

## /user/{id}
user_idを指定して、ユーザーの情報を読み取る

### example
要求URL:http://localhost/user/7

応答:
```json
{
    "user_id": 7,
    "username": "Odakura Reina",
    "password": "$2a$10$ZXKDoMtn9tFntBjcPx71gesF8FePmiGomg5y4WnSEpiS9cToVeoPK"
}
```

## /signup
ユーザー新規登録

### example
要求URL:http://localhost/signup

ペイロード:
```json
{
    "username": "WangPeiJun",
    "password": "123456"
}
```

応答:
Signup successfully!

## /login
ユーザーログイン

### example
要求URL:http://localhost/login

ペイロード:
```json
{
    "user_id": 3,
    "password": "yamashita123"
}
```

応答:
Welcome Yamashita Shizuki!

ログインエラーメッセージ:
Username or password invalid