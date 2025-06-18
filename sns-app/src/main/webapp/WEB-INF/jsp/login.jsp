<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="https://www.gstatic.com/firebasejs/9.22.1/firebase-app-compat.js"></script>
    <script src="https://www.gstatic.com/firebasejs/9.22.1/firebase-auth-compat.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 15px;
            background-color: #4285F4;
            color: white;
            border: none;
            cursor: pointer;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Login</h1>
    
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
    </div>
    
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
    </div>
    
    <button onclick="login()">Login</button>
    <button onclick="register()">Register</button>
    
    <div id="error" class="error"></div>
    
    <script>
        // Firebase configuration
        const firebaseConfig = {
            apiKey: "YOUR_API_KEY",
            authDomain: "YOUR_PROJECT_ID.firebaseapp.com",
            projectId: "YOUR_PROJECT_ID",
            storageBucket: "YOUR_PROJECT_ID.appspot.com",
            messagingSenderId: "YOUR_MESSAGING_SENDER_ID",
            appId: "YOUR_APP_ID"
        };
        
        // Initialize Firebase
        firebase.initializeApp(firebaseConfig);
        
        function login() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            
            firebase.auth().signInWithEmailAndPassword(email, password)
                .then((userCredential) => {
                    return userCredential.user.getIdToken();
                })
                .then((idToken) => {
                    // Send token to backend
                    return fetch('${pageContext.request.contextPath}/verifyToken.do', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({ idToken: idToken })
                    });
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        window.location.href = data.redirect;
                    } else {
                        document.getElementById('error').textContent = data.error;
                    }
                })
                .catch((error) => {
                    document.getElementById('error').textContent = error.message;
                });
        }
        
        function register() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            
            firebase.auth().createUserWithEmailAndPassword(email, password)
                .then((userCredential) => {
                    return userCredential.user.getIdToken();
                })
                .then((idToken) => {
                    // Send token to backend
                    return fetch('${pageContext.request.contextPath}/verifyToken.do', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({ idToken: idToken })
                    });
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        window.location.href = data.redirect;
                    } else {
                        document.getElementById('error').textContent = data.error;
                    }
                })
                .catch((error) => {
                    document.getElementById('error').textContent = error.message;
                });
        }
    </script>
</body>
</html>
