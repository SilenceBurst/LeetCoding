package proxy


class Owner : IService {

    override fun saleHouse() {
        System.out.println("房东：一手拿钱，一手交本")
    }
}