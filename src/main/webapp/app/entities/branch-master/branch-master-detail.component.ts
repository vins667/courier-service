import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBranchMaster } from 'app/shared/model/branch-master.model';

@Component({
  selector: 'jhi-branch-master-detail',
  templateUrl: './branch-master-detail.component.html',
})
export class BranchMasterDetailComponent implements OnInit {
  branchMaster: IBranchMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ branchMaster }) => (this.branchMaster = branchMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
