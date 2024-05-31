package org.thundernetwork.minecraft.slashhub

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

import java.util.HashMap
import java.util.regex.Pattern

class MessageFormatter {
    private val hexColorPattern = Pattern.compile("#[a-fA-F0-9]{6}")
    private val colorMap = HashMap<String, String>()

    init {
        colorMap["&0"] = "§0"
        colorMap["&1"] = "§1"
        colorMap["&2"] = "§2"
        colorMap["&3"] = "§3"
        colorMap["&4"] = "§4"
        colorMap["&5"] = "§5"
        colorMap["&6"] = "§6"
        colorMap["&7"] = "§7"
        colorMap["&8"] = "§8"
        colorMap["&9"] = "§9"
        colorMap["&a"] = "§a"
        colorMap["&b"] = "§b"
        colorMap["&c"] = "§c"
        colorMap["&d"] = "§d"
        colorMap["&e"] = "§e"
        colorMap["&f"] = "§f"
        colorMap["&k"] = "§k"
        colorMap["&l"] = "§l"
        colorMap["&m"] = "§m"
        colorMap["&n"] = "§n"
        colorMap["&o"] = "§o"
        colorMap["&r"] = "§r"
    }

    fun format(mm: MiniMessage, initialText: String): Component {
        var text = initialText
        for (entry in colorMap.entries) {
            text = text.replace(entry.key, entry.value)
        }

        val matcher = hexColorPattern.matcher(text)
        while (matcher.find()) {
            val color = text.substring(matcher.start(), matcher.end())
            text = text.replace(color, "<$color>")
        }

        return mm.deserialize(text)
    }
}