module.exports = {
    env: { browser: true, es2020: true },
    extends: [
        "eslint:recommended", 
        "plugin:react/recommended", 
        'plugin:react/jsx-runtime',
        "plugin:react-hooks/recommended"
    ],
    ignorePatterns: ['dist', '.eslintrc.cjs'],
    parserOptions: {
        ecmaVersion: 'latest',
        sourceType: "module"
    },
    rules: {
        semi: "error",
    }
}