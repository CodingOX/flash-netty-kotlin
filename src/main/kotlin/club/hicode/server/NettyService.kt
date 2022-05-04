package club.hicode.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel

private val PORT = 8000


fun main() {
    val bossGroup = NioEventLoopGroup()
    val workGroup = NioEventLoopGroup()

    val serverBootstrap = ServerBootstrap()

    serverBootstrap.group(bossGroup, workGroup)
        .channel(NioServerSocketChannel::class.java)
        .option(ChannelOption.SO_BACKLOG, 1024)
        .childOption(ChannelOption.SO_KEEPALIVE, true)
        .childOption(ChannelOption.TCP_NODELAY, true)
        .childHandler(object : ChannelInitializer<NioSocketChannel>() {
            override fun initChannel(ch: NioSocketChannel) {
                ch.pipeline().addLast()
            }

        })
}