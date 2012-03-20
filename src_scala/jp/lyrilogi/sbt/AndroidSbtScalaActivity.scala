package jp.lyrilogi.sbt

import android.app.Activity
import android.os.Bundle

class AndroidSbtScalaActivity extends Activity
{
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.scala_main);
  }
}

