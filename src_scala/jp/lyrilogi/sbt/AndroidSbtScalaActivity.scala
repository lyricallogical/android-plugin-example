package jp.lyrilogi.sbt

import android.app.Activity
import android.os.Bundle

class AndroidSbtScalaActivity extends Activity with TypedViewHolder
{
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.scala_main);

    findView(TR.textView).setText("hello sbt android-plugin");
  }
}

