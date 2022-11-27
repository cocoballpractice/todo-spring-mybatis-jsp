package com.cocoball.springp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    // 시작 페이지 번호
    private int start;

    // 끝 페이지 번호
    private int end;

    // 이전 페이지 존재 여부
    private boolean prev;

    // 다음 페이지 존재 여부
    private boolean next;

    // 링크
    private String link;

    private List<E> dtoList; // 기존에 전체 조회 시 내보내던 dto들 제네릭 처리리

    // 제네릭 처리
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;


        // 페이지 번호 계산
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;
        int last = (int)(Math.ceil(total/(double)size));
        this.end = end > last ? last: end;

        // 다음 페이지 여부
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }

    public int getSkip() {

        return (page - 1) * 10;

    }

    public String getLink() {
        if(link == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }
}
