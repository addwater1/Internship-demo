const path = require("path")
const HtmlWebpackPlugin = require("html-webpack-plugin")
const ESLintPlugin = require('eslint-webpack-plugin')

module.exports = {
    entry: path.resolve(__dirname, "./src/index.js"),
    output: {
        filename: "bundle.js",
        path: path.resolve(__dirname, "./dist"),
        clean: true
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_moudle/,
                use: {
                    loader: "babel-loader",
                }
            },
            {
                test: /\.css/,
                use: ["style-loader", "css-loader"]
            }
        ]
    },
    plugins: [
      new ESLintPlugin(),  
      new HtmlWebpackPlugin({
        template: "./index.html",
        filename: "index.html",
        inject: false,
        minify: true
      })
    ],
    devServer: {
        port: 8080,
        hot: true
    }
}