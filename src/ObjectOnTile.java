// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class ObjectOnTile extends Animable {
                     //ObjectAnimation
    public Model getRotatedModel()
    {
        int j = -1;
        if(aAnimation_1607 != null)
        {
            int k = client.loopCycle - delay;
            if(k > 100 && aAnimation_1607.frameStep > 0)
                k = 100;
            while(k > aAnimation_1607.getFrameLength(frame))
            {
                k -= aAnimation_1607.getFrameLength(frame);
                frame++;
                if(frame < aAnimation_1607.frameCount)
                    continue;
                frame -= aAnimation_1607.frameStep;
                if(frame >= 0 && frame < aAnimation_1607.frameCount)
                    continue;
                aAnimation_1607 = null;
                break;
            }
            delay = client.loopCycle - k;
            if(aAnimation_1607 != null)
                j = aAnimation_1607.frame2IDS[frame];
        }
        ObjectDef class46;
        if(anIntArray1600 != null)
            class46 = method457();
        else
            class46 = ObjectDef.forID(anInt1610);
        if(class46 == null)
        {
            return null;
        } else
        {
            return class46.method578(anInt1611, anInt1612, anInt1603, anInt1604, anInt1605, anInt1606, j);
        }
    }

    private ObjectDef method457()
    {
        int i = -1;
        if(anInt1601 != -1)
        {
            VarBit varBit = VarBit.cache[anInt1601];
            int k = varBit.configId;
            int l = varBit.rightShiftCount;
            int i1 = varBit.bit;
            int j1 = client.powersOfTwo[i1 - l];
            i = clientInstance.variousSettings[k] >> l & j1;
        } else
        if(anInt1602 != -1)
            i = clientInstance.variousSettings[anInt1602];
        if(i < 0 || i >= anIntArray1600.length || anIntArray1600[i] == -1)
            return null;
        else
            return ObjectDef.forID(anIntArray1600[i]);
    }

    public ObjectOnTile(int i, int j, int k, int l, int i1, int j1,
                         int k1, int l1, boolean randomize)
    {
        anInt1610 = i;
        anInt1611 = k;
        anInt1612 = j;
        anInt1603 = j1;
        anInt1604 = l;
        anInt1605 = i1;
        anInt1606 = k1;
        if(l1 != -1)
        {
            aAnimation_1607 = Animation.anims[l1];
            frame = 0;
            delay = client.loopCycle;
            if(randomize && aAnimation_1607.frameStep != -1)
            {
                frame = (int)(Math.random() * (double) aAnimation_1607.frameCount);
                delay -= (int)(Math.random() * (double) aAnimation_1607.getFrameLength(frame));
            }
        }
        ObjectDef class46 = ObjectDef.forID(anInt1610);
        anInt1601 = class46.configId_1;
        anInt1602 = class46.configID;
        anIntArray1600 = class46.configObjectIDs;
    }

    private int frame;
    private final int[] anIntArray1600;
    private final int anInt1601;
    private final int anInt1602;
    private final int anInt1603;
    private final int anInt1604;
    private final int anInt1605;
    private final int anInt1606;
    private Animation aAnimation_1607;
    private int delay;
    public static client clientInstance;
    private final int anInt1610;
    private final int anInt1611;
    private final int anInt1612;
}
