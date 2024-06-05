# アプリケーションのビルドと起動

## 環境
ローカル環境でmavenをインストール必要があります
```bash
❯ mvn --version 
Apache Maven 3.9.2 (c9616018c7a021c1c39be70fb2843d6f5f9b8a1c)
Maven home: /home/wpj/maven
Java version: 21.0.1, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-21.0.1
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.6.31-2-lts", arch: "amd64", family: "unix"
```

## 起動
プロジェクトのルートディレクトリに移動して、以下のコマンドを実行してspring bootアプリケーションを起動できる
```bash
mvn spring-boot:run
```

# データベースのインポート

/dumps/Dump20240528.sqlというファイルはアップロードして

以下のコマンドで、データベースをインポートできる
```bash
mysql -u wpj -p sheetdb < ./dump/Dump20240528.sql # ユーザーネームとパスワードを取り替えしてね
```
src/main/resources/application.ymlにもusernameとpasswordを取り替えしてね

# API Reference

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
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzIiwiZXhwIjoxNzE3NDkyOTE3fQ.rDHXvV6TENus5bA5Njm-NMmGGQ7uDg9QGAMKeF52Bsw",
    "user_id": 3,
    "username": "Yamashita Shizuki"
}
```

ログインエラーメッセージ:
Username or password invalid

## /all/users
すべてのユーザーを読み取る

### example
要求URL: http://localhost/all/users

http header: 
```
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzIiwiZXhwIjoxNzE3NDkyOTE3fQ.rDHXvV6TENus5bA5Njm-NMmGGQ7uDg9QGAMKeF52Bsw
```

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

tokenなしの場合:
Authentication failed

## /user/{id}
user_idを指定して、ユーザーの情報を読み取る

### example
要求URL:http://localhost/user/7

http header: 
```
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzIiwiZXhwIjoxNzE3NDkyOTE3fQ.rDHXvV6TENus5bA5Njm-NMmGGQ7uDg9QGAMKeF52Bsw
```

応答:
```json
{
    "user_id": 7,
    "username": "Odakura Reina",
    "password": "$2a$10$ZXKDoMtn9tFntBjcPx71gesF8FePmiGomg5y4WnSEpiS9cToVeoPK"
}
```

tokenなしの場合:
Authentication failed

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


