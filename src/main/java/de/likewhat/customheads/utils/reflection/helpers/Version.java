package de.likewhat.customheads.utils.reflection.helpers;

import de.likewhat.customheads.CustomHeads;

import java.util.Arrays;

public enum Version {

    OLDEST(0), V1_8_R1(181), V1_8_R2(182), V1_8_R3(183), V1_9_R1(191), V1_9_R2(192), V1_10_R1(1101), V1_11_R1(1111), V1_12_R1(1121), V1_13_R1(1131), V1_13_R2(1132), V1_14_R1(1141), V1_15_R1(1151), V1_16_R1(1161), V1_17_R1(1171), V1_18_R1(1181), LATEST(99999999);

    public final int versionValue;

    Version(int versionValue) {
        this.versionValue = versionValue;
    }

    private static Version fromValue(int value) {
        return Arrays.stream(values()).filter(r -> r.versionValue == value).findFirst().orElse(LATEST);
    }

    private static Version currentVersion;

    public boolean isOlderThan(Version version) {
        return this.versionValue < version.versionValue;
    }

    public boolean isNewerThan(Version version) {
        return this.versionValue > version.versionValue;
    }

    public static Version getCurrentVersion() {
        if(currentVersion != null) {
            return currentVersion;
        }
        currentVersion = fromValue(Integer.parseInt(CustomHeads.version.replaceAll("[^0-9]+", "")));
        return currentVersion;
    }
}
