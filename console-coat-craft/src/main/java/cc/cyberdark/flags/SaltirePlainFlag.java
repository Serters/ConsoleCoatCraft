package cc.cyberdark.flags;

import java.util.Arrays;

public class SaltirePlainFlag extends Flag {
    private static final double STANDARD_RATIO = 2.0/3.0;

    public SaltirePlainFlag(int width, String... colors) {
        super(width, (int)(width * STANDARD_RATIO), colors);
        if (colors.length != 2) {
            throw new IllegalArgumentException("Saltire Flag requires exactly 2 colors (background and saltire)");
        }
    }

    public SaltirePlainFlag(SaltirePlainFlag saltirePlainFlag) {
        this.width = saltirePlainFlag.width;
        this.height = saltirePlainFlag.height;
        this.colors = new String[2];
        System.arraycopy(saltirePlainFlag.colors, 0, this.colors, 0, 2);
    }

    @Override
    public String[] generate() {
        String[] flag = new String[this.height];
        String pad = "  ";
        Arrays.fill(flag, "");

        for (int y = 0; y < this.height; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < this.width; x++) {
                if (isSaltire(x, y)) {
                    row.append(colors[1]).append(pad);
                } else {
                    row.append(colors[0]).append(pad);
                }
            }
            flag[y] = row.toString();
        }

        return flag;
    }

    private boolean isSaltire(int x, int y) {
        double thickness = Math.min(width, height) / 8.0;
        
        double distToDiag1 = Math.abs(y - (double)height * x / width);
        double distToDiag2 = Math.abs(y - (double)height * (width - x - 1) / width);
        
        double normalizer = Math.sqrt(1 + Math.pow((double)height / width, 2));
        distToDiag1 /= normalizer;
        distToDiag2 /= normalizer;

        return distToDiag1 < thickness || distToDiag2 < thickness;
    }

    @Override
    public SaltirePlainFlag Clone() {
        return new SaltirePlainFlag(this);
    }


    @Override
    public void info() {
        System.out.println("Saltire Flag information: ");
        super.info();
    }
}