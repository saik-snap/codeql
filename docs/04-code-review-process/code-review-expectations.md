# Code Review Expectations

High level code review process

* Developer raise the PR and assign to lead, architect as reviewer. All reviewers are required.
* Lead gives the first level feedback on the PR. Change status to `wait for author`
* Lead and developer work to resolve the feedback comments. It is lead responsibility to resolve the comments that they have added
* Once lead approves, architect take a look at the PR and follow the same cycle
* Then, reviews and once he approves PR is merged to master. 

> Developers only have to create one PR for the issue.  Only in case lead or architect decide to abandon the PR then only you should create the new PR.

## Checklist

- [ ] Code review hierarchy
  * First level: Lead: Required
  * Second level: Architect: Required
  * Third level:  Required (Till September)
- [ ] Timely reviews
  * For leads it has to be the first priority
  * For architects it has to be under 24 hours
- [ ] Architects and leads should have their development environment ready
- [ ] Code should build. We might have to do manually till CI server is setup
- [ ] Functional correctness
  * Have you tested the APIs yourself by running the code on your machine
- [ ] Code aspects
  - [ ] Function names
  - [ ] Class design
  - [ ] API design and URIs
  - [ ] Logging
  - [ ] Database design
  - [ ] DB Indexes
  - [ ] Code clean up
  - [ ] Code uniformity
- [ ] Test quality
- [ ] Feedback should be documented in Azure DevOps
- [ ] Communicate using Teams

