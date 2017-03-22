package chapter5

import scala.beans.BeanProperty

/**
  * Created by carlos on 22/03/17.
  */
class Student (@BeanProperty var name: String, @BeanProperty var id: Long) {
}
