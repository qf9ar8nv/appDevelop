import 'dart:async';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_signin_button/flutter_signin_button.dart';
import 'package:google_sign_in/google_sign_in.dart';

import 'tab_page.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final GoogleSignIn _googleSignIn = GoogleSignIn();
  final FirebaseAuth _auth = FirebaseAuth.instance;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Instagram Clon',
              style: TextStyle(fontSize: 40.0, fontWeight: FontWeight.bold),
            ),
            Container(
              margin: EdgeInsets.all(50.0),
            ),
            SignInButton(
              Buttons.Google,
              onPressed: () {
                _handleSignIn();
              },
            ),
          ],
        ),
      ),
    );
  }

  Future<User> _handleSignIn() async {
    GoogleSignInAccount googleUser = await _googleSignIn.signIn();
    GoogleSignInAuthentication googleAuth = await googleUser.authentication;
    User user = (await _auth.signInWithCredential(
        GoogleAuthProvider.credential(
            idToken: googleAuth.idToken, accessToken: googleAuth.accessToken))).user;
    print("signed in " + user.displayName);
    return user;
  }
}
