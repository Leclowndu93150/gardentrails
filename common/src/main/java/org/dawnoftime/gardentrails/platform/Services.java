package org.dawnoftime.gardentrails.platform;

import org.dawnoftime.gardentrails.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = PlatformHolder.INSTANCE;

    private static class PlatformHolder {
        static final IPlatformHelper INSTANCE = load(IPlatformHelper.class);
    }

    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }
}