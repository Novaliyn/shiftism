package com.novaliyn.shiftism;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.potion.Potion;

public class ShiftedPotions {
    public static Potion shiftism;
    
    public static void register() {
        extend();
        add();
    }

    public static void extend() {
        for (Field f : Potion.class.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
                    Potion[] types = (Potion[]) f.get(null);
                    if (types.length >= 256) {
                        return;
                    }
                    Field modifiable = Field.class.getDeclaredField("modifiers");
                    modifiable.setAccessible(true);
                    modifiable.setInt(f, f.getModifiers() & ~Modifier.FINAL);
                    Potion[] newTypes = new Potion[256];
                    System.arraycopy(types, 0, newTypes, 0, types.length);
                    f.set(null, newTypes);
                    return;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void add() {
        shiftism = new PotionShiftism(390, false, 0xffffff).setPotionName("potion.shiftism");
        
    }

}
