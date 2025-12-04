package pizzeria;

import java.util.EnumSet;
import java.util.Set;

public class Pizza extends Producto implements Preparacion {

    private final Size size;
    private final Masa masa;
    private final Salsa salsa;
    private final Set<Topping> toppings;
    private final boolean bordesRellenos;
    private final boolean sinGluten;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.masa = builder.masa;
        this.salsa = builder.salsa;
        this.toppings = builder.toppings;
        this.bordesRellenos = builder.bordesRellenos;
        this.sinGluten = builder.sinGluten;
        this.nombre = "Pizza personalizada";

    }

    CharSequence[] getIngredientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static class Builder {

        private Size size;
        private Masa masa;
        private Salsa salsa;
        private Set<Topping> toppings = EnumSet.noneOf(Topping.class);
        private boolean bordesRellenos;
        private boolean sinGluten;

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder masa(Masa masa) {
            this.masa = masa;
            return this;
        }

        public Builder salsa(Salsa salsa) {
            this.salsa = salsa;
            return this;
        }

        public Builder addTopping(Topping topping) {
            toppings.add(topping);
            return this;
        }

        public Builder bordesRellenos(boolean v) {
            this.bordesRellenos = v;
            return this;
        }

        public Builder sinGluten(boolean v) {
            this.sinGluten = v;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public double getPrecio() {
        int base = switch (size) {
            case PERSONAL ->
                15000;
            case MEDIANA ->
                22000;
            case FAMILIAR ->
                30000;
        };
        base += toppings.size() * 3000;
        if (bordesRellenos) {
            base += 4000;
        }
        if (sinGluten) {
            base += 5000;
        }
        return base;
    }

    public String resumen() {
        return """
               PIZZA
               Tamaño: %s
               Masa: %s
               Salsa: %s
               Toppings: %s
               Bordes Rellenos: %s
               Sin Gluten: %s
               Precio: $%,d
               """.formatted(
                size, masa, salsa,
                toppings.isEmpty() ? "ninguno" : toppings,
                bordesRellenos ? "sí" : "no",
                sinGluten ? "sí" : "no",
                getPrecio()
        );
    }

    @Override
    public void preparar() {
        System.out.println("Cocinando la pizza " + this.toString());
    }
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" Pizza creada con:\n");
    sb.append("- Tamaño: ").append(size).append("\n");
    sb.append("- Masa: ").append(masa).append("\n");
    sb.append("- Salsa: ").append(salsa).append("\n");

    if (toppings != null && !toppings.isEmpty()) {
        sb.append("- Toppings: ").append(toppings).append("\n");
    }

    sb.append("- Bordes rellenos: ").append(bordesRellenos ? "Sí" : "No").append("\n");
    sb.append("- Sin gluten: ").append(sinGluten ? "Sí" : "No").append("\n");

    return sb.toString();
}

}
