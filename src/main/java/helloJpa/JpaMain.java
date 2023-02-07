package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
           /* Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");*/

            /*Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJpa");*/

            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
*/
           /* Member member = new Member();
            member.setId(101L);
            member.setName("HelloJpa");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");*/

            /*Member findMember = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember == findMember2));

            System.out.println("TEST"+findMember.getId());
            System.out.println("TEST"+findMember.getName());*/

            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
*/
/*            Member member = em.find(Member.class, 150L);
            member.setName("C");*/
/*
            Member member1 = new Member(200L, "member200");
            em.persist(member1);*/

            // 1차 캐시 db 동기화 처리 진행


            Member member = em.find(Member.class, 150L);
            member.setName("C");

            em.detach(member);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
