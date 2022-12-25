/**
 * 부모/자식 관계, 형제 관계에 해당하는 엘리먼트에 접근하기 위한 방법
 * 
 * 자식에게 접근
 *    엘리먼트객체.children                : 선택된 엘리먼트를 기준으로 자식들의 엘리먼트 객체 정보 반환
 *    엘리먼트객체.firstElementChild       : 선택된 엘리먼트를 기준으로 첫번째 자식 엘리먼트 객체 정보 반환
 *    엘리먼트객체.lastElementChild        : 선택된 엘리먼트를 기준으로 마지막 자식 엘리먼트 객체 정보 반환
 * 
 * 부모에게 접근
 *    엘리먼트객체.parentElement           : 선택된 엘리먼트를 기준으로 부모 엘리먼트 객체 정보 반환
 * 
 * 인접 형제에게 접근
 *    엘리먼트객체.previousElementSibling  : 선택된 엘리먼트를 기준으로 이전 형제 엘리먼트 객체 정보 반환
 *    엘리먼트객체.nextElementSibling      : 선택된 엘리먼트를 기준으로 다음 형제 엘리먼트 객체 정보 반환
 */
function counting(element) {
    /**
     * tr 태그 영역이 클릭되면 조회수가 +1 이 되게 한다.
     */
    var cnt = parseInt(element.lastElementChild.innerText);
    element.lastElementChild.innerText = cnt + 1;
}
