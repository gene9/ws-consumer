package com.lightdruid.examples.ws_consumer

import java.sql.DriverManager

import org.jooq.SQLDialect
import org.jooq.impl.{DSL}

object WsConsumer extends App {
  println("test")

  val c = DriverManager.getConnection("jdbc:postgresql:test", "test", "test");
  val e = DSL.using(c, SQLDialect.POSTGRES);

  println(e.fetch("select id from white_list"))
}
