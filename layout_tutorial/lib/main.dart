import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    var titleSection = Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Text("Ocehns Lake Comapgroud",
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24)),
            Text("Kandresteg, Switzerland",
                style: TextStyle(color: Colors.grey, fontSize: 24)),
          ],
        ),
        Padding(
          padding: EdgeInsets.all(15.0),
        ),
        Icon(
          Icons.star,
          size: 35,
          color: Colors.deepOrange,
        ),
        Text(
          '41',
          style: TextStyle(fontSize: 30),
        )
      ],
    );
    var buttonSection = Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Column(
          children: <Widget>[
            Icon(
              Icons.call,
              size: 40,
              color: Colors.lightBlue,
            ),
            Text(
              'CALL',
              style: TextStyle(color: Colors.lightBlue),
            )
          ],
        ),
        Padding(
          padding: EdgeInsets.all(30.0),
        ),
        Column(
          children: <Widget>[
            Icon(
              Icons.near_me,
              size: 40,
              color: Colors.lightBlue,
            ),
            Text('ROUTE', style: TextStyle(color: Colors.lightBlue))
          ],
        ),
        Padding(
          padding: EdgeInsets.all(30.0),
        ),
        Column(
          children: <Widget>[
            Icon(
              Icons.share,
              size: 40,
              color: Colors.lightBlue,
            ),
            Text('SHARE', style: TextStyle(color: Colors.lightBlue))
          ],
        )
      ],
    );
    var textSection = Container(
      child: Text(
          'text style'
          'dasldifjowiejoisoig'
          'sdloijqoigjoiwjg',
          style: TextStyle(fontSize: 20)),
      padding: EdgeInsets.all(15.0),
    );

    return Scaffold(
      body: Column(
        children: <Widget>[
          Image.network(
              "https://cdn.crowdpic.net/list-thumb/thumb_l_3A818FA9ADA544FCF53BB966BC0A5E00.jpg",
              height: 240,
              width: 600,
              fit: BoxFit.cover),
          Padding(
            padding: EdgeInsets.all(15.0),
          ),
          titleSection,
          Padding(
            padding: EdgeInsets.all(15.0),
          ),
          buttonSection,
          Padding(
            padding: EdgeInsets.all(0.0),
          ),
          textSection
        ],
      ),
    );
  }
}
