package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

   private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 동시성 이슈가 있을 수 있어서 ConcurrentHashMap을 사용해야 한다.


    @Override
    public void save(Member member) { // 회원을 저장하는 기능
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) { // 회원을 아이디로 찾는 기능
        return store.get(memberId);
    }
}
