# Socket_android_simple
Read read.md
This android app uses socket.io and it is a simple implimentation of how socket io works.

For server socket.io implimentation (written in node.js) go here: https://github.com/abheekaryan/AndroidSocketTest
Note: packages needed via npm(for server)
     1. socket.io (terminal- npm intstall socket.io)
     2. express (terminal- npm install express)
     3. nodemon (terminal- npm install nodemon)

For client:
Do this.
    1. AndroidManifest.xml file : 
    // uses-permission android:name="android.permission.INTERNET" 
      
    2. build.gradle module level: 
        implementation ('io.socket:socket.io-client:2.1.0') {
        // excluding org.json which is provided by Android
        exclude group: 'org.json', module: 'json'
    }

Thanks )) ⭐⭐⭐⭐⭐
