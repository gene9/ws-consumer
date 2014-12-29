package com.lightdruid.examples.ws_consumer

import java.sql.{Timestamp, DriverManager}

import org.joda.time.DateTime
import org.jooq.SQLDialect
import org.jooq.impl.{DSL}

import com.lightdruid.examples.generated.tables._

object WsConsumer extends App {
  println("test")

  val c = DriverManager.getConnection("jdbc:postgresql:test", "test", "test");
  val e = DSL.using(c, SQLDialect.POSTGRES);

  println(e.fetch("select id from white_list"))
  
  val now = new Timestamp(DateTime.now.getMillis())
  val rec = e.select(WhiteList.WHITE_LIST.ID, WhiteList.WHITE_LIST.IP)
    .from(WhiteList.WHITE_LIST)
    .where(WhiteList.WHITE_LIST.CREATED_AT.gt(now))
    .fetchOne()

  println(rec.getValue("ip"))
  println(rec.value2())
}
