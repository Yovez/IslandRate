package com.yovez.islandrate.misc;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.yovez.islandrate.IslandRate;

public class CustomConfig {

	private final String path;
	private final String name;
	private final IslandRate core;
	private FileConfiguration config;
	private File file;

	public CustomConfig(IslandRate core, String path, String name) {
		this.core = core;
		this.path = path;
		this.name = name;
	}

	public void loadConfig() {
		file = new File(path, name + ".yml");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			if (core.getResource(name + ".yml") != null)
				core.saveResource(name + ".yml", false);
		}
		config = new YamlConfiguration();
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public FileConfiguration getConfig() {
		if (config == null)
			loadConfig();
		return config;
	}

	public void saveConfig() {
		if (config == null)
			loadConfig();
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
