package club.hicode.protocol

import com.alibaba.fastjson2.annotation.JSONField

/**
 * 基本的包的类型
 * @property version Byte
 * @property command Byte
 */
abstract class Packet {

    @JSONField(write = false, read = false)
    private val version: Byte = 1

    /**
     * 命令参数，表示该类属于什么的结构参数
     */
    @get:JSONField(write = false)
    abstract val command: Byte

}
