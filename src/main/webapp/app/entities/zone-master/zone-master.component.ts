import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IZoneMaster } from 'app/shared/model/zone-master.model';
import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { ZoneMasterService } from './zone-master.service';
import { ZoneMasterDeleteDialogComponent } from './zone-master-delete-dialog.component';
import { IZoneMasterSearch, ZoneMasterSearch } from 'app/shared/model/zone-master-search.model';

@Component({
  selector: 'jhi-zone-master',
  templateUrl: './zone-master.component.html',
})
export class ZoneMasterComponent implements OnInit, OnDestroy {
  zoneMasters?: IZoneMaster[];
  zoneMasterSearch: IZoneMasterSearch;
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;
  isProcess = false;

  constructor(
    protected zoneMasterService: ZoneMasterService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {
    this.zoneMasterSearch = new ZoneMasterSearch();
  }

  search(): void {
    const pageToLoad = 1;
    this.zoneMasterSearch.size = ITEMS_PER_PAGE;
    this.zoneMasterSearch.pageNo = 0;
    this.page = 1;
    this.isProcess = true;
    this.zoneMasterService.queryCustom(this.zoneMasterSearch).subscribe(
      (res: HttpResponse<IZoneMaster[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
      () => this.onError()
    );
  }

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;
    this.zoneMasterSearch.size = this.itemsPerPage;
    this.zoneMasterSearch.pageNo = pageToLoad - 1;
    this.zoneMasterService.queryCustom(this.zoneMasterSearch).subscribe(
      (res: HttpResponse<IZoneMaster[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
      () => this.onError()
    );
  }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data => {
      this.page = data.pagingParams.page;
      this.ascending = data.pagingParams.ascending;
      this.predicate = data.pagingParams.predicate;
      this.ngbPaginationPage = data.pagingParams.page;
      this.loadPage();
    });
    this.handleBackNavigation();
    this.registerChangeInZoneMasters();
  }

  handleBackNavigation(): void {
    this.activatedRoute.queryParamMap.subscribe((params: ParamMap) => {
      const prevPage = params.get('page');
      const prevSort = params.get('sort');
      const prevSortSplit = prevSort?.split(',');
      if (prevSortSplit) {
        this.predicate = prevSortSplit[0];
        this.ascending = prevSortSplit[1] === 'asc';
      }
      if (prevPage && +prevPage !== this.page) {
        this.ngbPaginationPage = +prevPage;
        this.loadPage(+prevPage);
      } else {
        this.loadPage(this.page);
      }
    });
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IZoneMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInZoneMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('zoneMasterListModification', () => this.loadPage());
  }

  delete(zoneMaster: IZoneMaster): void {
    const modalRef = this.modalService.open(ZoneMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.zoneMaster = zoneMaster;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected onSuccess(data: IZoneMaster[] | null, headers: HttpHeaders, page: number): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/zone-master'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc'),
      },
    });
    this.zoneMasters = data || [];
    this.isProcess =false;
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
