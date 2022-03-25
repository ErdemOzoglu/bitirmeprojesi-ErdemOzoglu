<template>
    <div id="products">
        <div class="filter">
            <div>
                <h1>Ürün tipine göre filtreleme</h1>
                <el-select
                    v-model="filteredProductType"
                    size="small"
                    style="margin-bottom: 10px"
                >
                    <el-option v-for="type in productTypes" :key="type" :value="type" :label="type"></el-option>
                </el-select>
                <el-button size="small" type="primary" @click="filterByType"
                    >Filtrele</el-button
                >
            </div>
            <div>
                <h1>Ürün fiyatına göre filtreleme</h1>
                <el-slider v-model="filterPrice" range max="1000"></el-slider>
                <el-button size="small" type="primary" @click="filterByPrice"
                    >Filtrele</el-button
                >
            </div>
        </div>
        <div class="table">
            <el-table :data="products">
                <el-table-column prop="productName" label="Başlık"> </el-table-column>
                <el-table-column prop="productType" label="Ürün Grubu"> </el-table-column>
                <el-table-column prop="firstPrice" label="Vergisiz Fiyat"> </el-table-column>
                <el-table-column prop="lastPrice" label="Vergi Dahil Fiyat"> </el-table-column>
                <el-table-column label="İşlemler">
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            type="primary"
                            @click="handleEdit(scope.row)"
                            >Düzenle</el-button
                        >
                        <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)"
                            >Sil</el-button
                        >
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <el-dialog
            title="Ürün Düzenle"
            :visible.sync="dialogVisible"
            width="30%"
            class="edit-module"
        >
            <div class="label">
                <span>Başlık</span>
                <el-input size="small" placeholde="Başlık"></el-input>
            </div>
            <div class="label">
                <span>Fiyat</span>
                <el-input size="small" placeholde="Fiyat"></el-input>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">Vazgeç</el-button>
                <el-button type="primary" @click="edit">Kaydet</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "Products",
    data() {
        return {
            products: [],
            dialogVisible: false,
            editProductId: null,
            filteredProductType: null,
            filterPrice: null,
            productTypes: [
                "GIDA",
                "KIRTASIYE",
                "GIYECEK",
                "TEKLONOJI",
                "TEMIZLIK",
                "DIGER"
            ]
        };
    },
    mounted() {
        axios.get("api/v1/product").then((res) => {
            this.products = res.data.data;
        });
    },
    methods: {
        handleEdit(item) {
            this.dialogVisible = true;
            this.editProductId = item.id;
        },
        edit() {
            this.dialogVisible = false;
        },
        filterByType() {
            axios.get("api/v1/product/" + this.filteredProductType).then((res) => {
                this.products = res.data.data;
            });
        },
        filterByPrice() {
            axios.get("api/v1/product/productsFilterByPrice?minPrice=" + this.filterPrice[0] + "&maxPrice=" + this.filterPrice[1]).then((res) => {
                this.products = res.data.data;
            });},
    },
};
</script>

<style lang="less">
#products {
    width: 100%;
    display: flex;
    .filter {
        width: 250px;
        margin-right: 20px;
        & > div {
            width: 100%;
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
            h1 {
                font-size: 15px;
                margin-bottom: 10px;
            }
        }
    }
    .table {
        flex: 1;
    }
    .edit-module {
        .label {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
            span {
                margin-bottom: 10px;
            }
        }
    }
}
</style>
