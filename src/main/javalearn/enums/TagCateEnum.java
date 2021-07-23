package enums;

public enum TagCateEnum {
    XQJN("xqjn"), XQPP("xqpp"), XQCS("xqcs"), XQHY("xqhy"), XQJY("xqjy"), XQGT("xqgt"), XQDY("xqdy"), XQNL(
            "xqnl"), XQRA("xqra"), XQRJ("xqrj"), XQSG("xqsg"), XQSJ("xqsj"), XQWG("xqwg"), XQXB("xqxb"), XQXQ(
            "xqxq"), XQXX("xqxx"), XQXL("xqxl"), XQZS("xqzs"), XQZY("xqzy"), XQZBC("xqzbc"), ZXXFS(
            "zxxfs"), FLBX("flbx"), FLBT("flbt"), FLJQ("fljq"), FLJR("fljr"), FLLY("flly"), FLCCZ(
            "flccz"), FLDD("fldd"), FLHJ("flhj"), FLJL("fljl"), FLRPJ("flrpj"), FLXZ(
            "flxz"), JBN("jbn"), XZM("xzm"), NEGATIVE("negative"), SECONDCATE(
            "secondcate"), FULI("fuli"), THIRDCATE("thirdcate"), RESUME("resume"), VCATE("virtualCategory");

    TagCateEnum(String cate) {
        this.cate = cate;
    }

    private String cate;

    public String getTagCate() {
        return cate;
    }
}