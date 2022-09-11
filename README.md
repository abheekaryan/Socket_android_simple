# Socket_android_simple

*This android app uses socket.io and it is a simple implimentation of how socket io works.*

For server socket.io implimentation (written in node.js) go here: https://github.com/abheekaryan/AndroidSocketTest
Note: packages needed via npm(for server)
     1. socket.io (terminal- npm intstall socket.io)
     2. express (terminal- npm install express)
     3. nodemon (terminal- npm install nodemon)

For client:
Do this.
    1. AndroidManifest.xml file : 
     uses-permission android:name="android.permission.INTERNET" 
      
    2. build.gradle module level: 
        implementation ('io.socket:socket.io-client:2.1.0') {
        // excluding org.json which is provided by Android
        exclude group: 'org.json', module: 'json'
    }

Screenshots
![alt text](https://i.postimg.cc/jjqTgdYH/20220911091803-Screenshot-2022-09-11-08-54-17-88-ed8326c92e20518c9db61cf0bb9c9386.png)
![alt text](https://i.postimg.cc/CLpWrLjR/20220911091805-Screenshot-2022-09-11-08-54-23-09-ed8326c92e20518c9db61cf0bb9c9386.png)

Thanks ⭐⭐⭐⭐⭐
