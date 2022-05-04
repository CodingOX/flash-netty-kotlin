package club.hicode.protocol

import club.hicode.protocol.request.LoginRequestPacket


/**
 * 包的协议工具类？
 *
 * @author Liu Chunfu
 * @date 2022-05-04 4:43 PM
 **/
object PacketCodeC {

    const val MAGIC_NUMBER: Int = 0x12345678

    /**
     * out可以接受自己的子类赋值，因为赋值的目的是获取
     */
    private val packetTypeMap = HashMap<Byte, Class<out Packet>>()


    init {
        packetTypeMap[1] = LoginRequestPacket::class.java

    }
}


open class Fruit(val weight: Double)

class Apple(weight: Double) : Fruit(weight)

class Banana(weight: Double) : Fruit(weight)

/**
 * 定义泛型和泛型参数是有区别的？
 * extend 和 : 都表示的上界约束
 *
 * @param T:Fruit
 */
class FruitPlate<T : Fruit>(val t: T)

/**
 * Ground是地面的意思
 */
interface Ground {

}

class Watermelon(weight: Double) : Fruit(weight), Ground


fun <T> cut(t: T) where T : Fruit, T : Ground {
    println("You can cut me")
}


fun main() {

    FruitPlate(Apple(1.0))
    FruitPlate(Banana(1.0))

    cut(Watermelon(3.0))
    //cut(Banana(3.0))
}
