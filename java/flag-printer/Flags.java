public enum Flags {
        RAINBOW(new Rgb[] {
                        new Rgb(228, 3, 3),
                        new Rgb(255, 140, 0),
                        new Rgb(255, 237, 0),
                        new Rgb(0, 128, 38),
                        new Rgb(0, 77, 255),
                        new Rgb(117, 7, 135)
        }, "Rainbow"),
        TRANSGENDER(new Rgb[] {
                        new Rgb(91, 206, 250),
                        new Rgb(245, 169, 184),
                        new Rgb(255, 255, 255),
                        new Rgb(245, 169, 184),
                        new Rgb(91, 206, 250)
        }, "Transgender"),
        FEMBOY(new Rgb[] {
                        new Rgb(255, 153, 170),
                        new Rgb(255, 255, 255),
                        new Rgb(102, 153, 255),
                        new Rgb(255, 255, 255),
                        new Rgb(255, 153, 170)
        }, "Femboy"),
        ASEXUAL(new Rgb[] {
                        new Rgb(0, 0, 0),
                        new Rgb(164, 164, 164),
                        new Rgb(255, 255, 255),
                        new Rgb(129, 0, 129)
        }, "Asexual"),
        BISEXUAL(new Rgb[] {
                        new Rgb(214, 2, 112),
                        new Rgb(155, 79, 150),
                        new Rgb(0, 56, 168)
        }, "Bisexual"),
        PANSEXUAL(new Rgb[] {
                        new Rgb(255, 33, 140),
                        new Rgb(255, 218, 0),
                        new Rgb(33, 177, 255)
        }, "Pansexual"),
        LESBIAN(new Rgb[] {
                        new Rgb(214, 41, 0),
                        new Rgb(255, 155, 85),
                        new Rgb(255, 255, 255),
                        new Rgb(212, 97, 166),
                        new Rgb(162, 0, 98)
        }, "Lesbian"),
        NON_BINARY(new Rgb[] {
                        new Rgb(255, 244, 52),
                        new Rgb(255, 255, 255),
                        new Rgb(156, 89, 209),
                        new Rgb(0, 0, 0)
        }, "Non-binary");

        private final Rgb[] colors;
        private final String name;

        Flags(Rgb[] colors, String name) {
                this.colors = colors;
                this.name = name;
        }

        public Rgb[] getColors() {
            return colors;
        }
        
        public String getName() {
            return name;
        }
}
