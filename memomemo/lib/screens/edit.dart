import 'package:flutter/material.dart';

class EditPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        color: Colors.blue,
        child: Align(
          alignment: Alignment.center,
          child: Icon(
            Icons.star,
            size: 60,
          ),
        ),
      ),
    );
  }
}

class Data extends StatefulWidget {
  @override
  _DataState createState() => _DataState();
}

class _DataState extends State<Data> {
  @override
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.center,
      color: Colors.blue,
    );
  }
}

