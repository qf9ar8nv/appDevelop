import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

class Cupertinopage extends StatefulWidget {
  @override
  _CupertinopageState createState() => _CupertinopageState();
}

class _CupertinopageState extends State<Cupertinopage> {
  bool _switch = true;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CupertinoNavigationBar(
        middle: Text('쿠퍼티노 UI'),
      ),
      body: Column(
        children: <Widget>[
          CupertinoButton(
              child: Text('쿠퍼티노 버튼'), onPressed: null
          ),
          CupertinoSwitch(
              value: _switch, onChanged: (bool value){
                setState(() {
                  _switch = value;
                });
            }
          ),
          RaisedButton(child: Text('머터리얼 버튼'),onPressed: null),
          Switch(
            value: _switch, onChanged: (bool value){
            setState(() {
              _switch = value;
            });
          },
          )
        ],
      ),
    );
  }
}
