package proxy

class OwnerProxy(val owner: Owner) : IService {

    override fun saleHouse() {
        System.out.println("中介：找客户")
        System.out.println("中介：看房")
        System.out.println("中介：拟定合同")
        owner.saleHouse()
    }
}