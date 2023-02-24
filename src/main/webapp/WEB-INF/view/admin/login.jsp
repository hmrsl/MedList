<html>
  <head>
    <title>
      Sign up
    </title>
    <style>
      body {
        font-family: Arial, Helvetica, sans-serif;
        color: #053819;
        background-color: rgb(151, 255, 187);
        background-image: url(images/1.jpg);
        background-size: 100% 100%;
        padding-top: 5%;
      }
      * {
        box-sizing: border-box;
      }
      .container {
        padding: 16px;
        background-color: rgb(158, 202, 175);
      }
      input[type="text"],
      input[type="email"],
      input[type="password"] {
        width: 100%;
        height: 5px;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        outline: none;
        background: rgb(228, 230, 227);
      }
      input[type="text"]:focus,
      input[type="email"]:focus,
      input[type="password"]:focus {
        background-color: #15a144;
        outline: none;
      }
      .registerbtn {
        background-color: rgb(144, 219, 151);
        border-color: #053819;
        color: #053819;
        padding: 16px 20px;
        margin: 8px;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
      }
      .registerbtn:hover {
        opacity: 1;
      }
      a {
        color: blue;
      }
      .login{
          background: rgb(160, 163, 162);
          text-align: center;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <form>
        <h1>Sign up</h1>
        <p>Please fill this form to create an account</p>
        <hr />
        <label>Name</label>
        <input type="text" placeholder="Name" />
        <br />
        <label>Email</label>
        <input type="email" placeholder="Email" />
        <br />
        <label>Password</label>
        <input type="password" placeholder="Password" />
        <br />
        <label>Re-password</label>
        <input type="password" placeholder="Re-password" />
        <p>
          By creating an account you agree to our
          <a href="#">Terms and Privacy</a>
        </p>

        <button class="registerbtn">Sign Up</button>
      
        <div class="login">
        <p>Already have account?<a href="#">Login</a></p>
      </form>
    </div>
</div>
  </body>
</html>