import 'package:flutter/material.dart';
import 'package:hello_world/model/model_movie.dart';
import 'package:hello_world/screen/empty_screen.dart';
import 'dart:ui';


class DetailScreen extends StatefulWidget {
  final Movie movie;
  DetailScreen({this.movie});
  @override
  _DetailScreenState createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  bool like = false;
  @override
  void initState() {
    super.initState();
    like = widget.movie.like;
  }

  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: SafeArea(
          child: ListView(
            children: <Widget>[
              Stack(
                children: <Widget>[
                  Container(
                    width: double.maxFinite,
                    decoration: BoxDecoration(
                      image: DecorationImage(
                        image: AssetImage('images/'+ widget.movie.poster),
                        fit: BoxFit.cover,
                      )
                    ),
                    child: ClipRect(child: BackdropFilter(
                      filter: ImageFilter.blur(sigmaX: 10, sigmaY: 10),
                      child: Container(alignment: Alignment.center,
                      color: Colors.black.withOpacity(0.1),
                      child: Container(
                        child: Column(children: <Widget>[
                          Container(padding: EdgeInsets.fromLTRB(0, 45, 0, 10),
                          child: Image.asset(
                            'images/'+ widget.movie.poster
                          ),
                          height: 250,),
                          Container(
                            padding: EdgeInsets.all(7),
                            child: Text(
                              '99% 일치 2019 15+ 시즌 1개',
                              textAlign: TextAlign.center,
                              style: TextStyle(fontSize: 13),
                            ),
                          ),
                          Container(
                            padding: EdgeInsets.all(7),
                            child: Text(widget.movie.title,
                            textAlign: TextAlign.center,
                            style: TextStyle(fontSize: 13, fontWeight: FontWeight.bold,),),
                          ),
                          Container(
                            padding: EdgeInsets.all(3),
                            child: FlatButton(
                              onPressed: () {},
                              color: Colors.red,
                              child: Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: <Widget>[
                                Icon(Icons.play_arrow),
                                Text('재생'),
                              ],),
                            ),
                          )
                        ],),
                      ),),
                    ),),
                  ),
                  Positioned(child: AppBar(
                    backgroundColor: Colors.transparent,
                    elevation: 0,
                  ))
                ],
              ),
              makeMenuButton(),
            ],
          ),
        ),
      ),
    );
  }
}

Widget makeMenuButton(){
  return Container(

  );
}