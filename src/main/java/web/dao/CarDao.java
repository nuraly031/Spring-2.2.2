package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.Car;

import java.util.List;


@Component
public class CarDao {

    private final SessionFactory sessionFactory;

    public CarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Car> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select c from Car c", Car.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Car indexCount(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    @Transactional
    public void save(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
    }

    @Transactional
    public void update(int id, Car updated) {
        Session session = sessionFactory.getCurrentSession();
        Car carToBeUpdated = session.get(Car.class, id);

        carToBeUpdated.setName(updated.getName());
        carToBeUpdated.setColor(updated.getColor());
        carToBeUpdated.setNumber(updated.getNumber());
        carToBeUpdated.setId(updated.getId());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Car.class, id));
    }

}