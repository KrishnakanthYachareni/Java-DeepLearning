package ua.epam.spring.hometask.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Krishnakanth_Yachareni
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestAuditoriumDao {

    @Autowired
    private AuditoriumDao auditoriumDao;

    @Test
    public void testGetByName() {
        assertThat("PVR", equalTo(auditoriumDao.getByName("PVR").getName()));
    }

    @Test
    public void testGetAll() {
        assertThat(3, equalTo(auditoriumDao.getAll().size()));
    }
}
