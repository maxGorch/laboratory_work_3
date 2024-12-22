package org.example.goods;

import java.util.List;

public class goodsBatch {
    private final String description; // Описание партии товаров
    private final List<packedGoodsPiece> packedGoodsPieces; // Список упакованных штучных товаров
    private final List<packedGoodsWeighted> packedGoodsWeighted; // Список упакованных весовых товаров

    // Конструктор, принимающий описание и два списка товаров
    public goodsBatch(String description, List<packedGoodsPiece> packedGoodsPieces, List<packedGoodsWeighted> packedGoodsWeighted) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Описание партии товаров не может быть пустым.");
        }
        if (packedGoodsPieces == null || packedGoodsPieces.isEmpty()) {
            throw new NullPointerException("Список упакованных товаров не может быть null.");
        }
        if (packedGoodsWeighted == null || packedGoodsWeighted.isEmpty()) {
            throw new NullPointerException("Список упакованных весовых товаров не может быть null.");
        }
        this.description = description;
        this.packedGoodsPieces = packedGoodsPieces;
        this.packedGoodsWeighted = packedGoodsWeighted;
    }

    public String getDescription() {
        return description;
    }

    public List<packedGoodsWeighted> getPackedGoodsWeighted() {
        return packedGoodsWeighted;
    }

    public List<packedGoodsPiece> getPackedGoodsPieces() {
        return packedGoodsPieces;
    }

    // Метод для получения массы всей партии (суммарная масса брутто)
    public double getTotalGrossMass() {
        double totalGrossMass = 0;

        // Считаем массу брутто для упакованных штучных товаров
        if (packedGoodsPieces != null) {
            for (packedGoodsPiece piece : packedGoodsPieces) {
                totalGrossMass += piece.getMassGross();
            }
        }

        // Считаем массу брутто для упакованных весовых товаров
        if (packedGoodsWeighted != null) {
            for (packedGoodsWeighted weighted : packedGoodsWeighted) {
                totalGrossMass += weighted.getMassGross();
            }
        }

        return totalGrossMass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Партия товаров: ").append(description).append("\n");

        sb.append("Упакованные штучные товары:\n");
        if (packedGoodsPieces != null) {
            for (packedGoodsPiece piece : packedGoodsPieces) {
                sb.append(piece.toString()).append("\n");
            }
        }

        sb.append("Упакованные весовые товары:\n");
        if (packedGoodsWeighted != null) {
            for (packedGoodsWeighted weighted : packedGoodsWeighted) {
                sb.append(weighted.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
