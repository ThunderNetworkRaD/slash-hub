package org.thundernetwork.minecraft.slashhub

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger

@Plugin(
    id = "slashhub",
    name = "Slash Hub",
    version = BuildConstants.VERSION,
    description = "Slash Hub",
    authors = ["ThunderNetworkRaD", "KillerBossOriginal"]
)
class SlashHub {
    @Inject
    private val logger: Logger? = null

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent?) {
        if (logger === null) {
            throw NullPointerException("Logger is null")
        }
        logger.info("ThunderNetwork's SlashHub Loaded!")
    }
}
