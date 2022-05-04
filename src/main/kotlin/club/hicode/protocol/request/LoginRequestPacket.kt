package club.hicode.protocol.request

import club.hicode.protocol.Packet


/**
 * 请求登录的包
 *
 * @author Liu Chunfu
 * @date 2022-05-04 5:30 PM
 **/
class LoginRequestPacket : Packet() {

    var userId: String? = null

    var userName: String? = null

    var password: String? = null


    override val command: Byte
        get() = 1
}
