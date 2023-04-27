*
# Requirements: 
Build a Task Management System that was defined by the following business needs:

* A supervisor can define/schedule tasks for certain members of her team
* Tasks have a name, due date, instructions, a list of assigned personnel, etc.
* Once the supervisor publishes a task all assigned personnel can see it on their dashboard
* Any assigned personnel can complete a task by entering a completion date/time and a completion comment
* On my personnel tasks dashboard I see tasks sorted by due date. Overdue tasks are specially marked
* The supervisor can see the list of all her team members. She can also see filtered lists of tasks (by team member or task status, etc.)
* The supervisor can cancel or table published tasks.

# Model
Task
* name: String
* status: enum of [new, published, completed]
* dueDate: Date
* instructions: String
* completedDate: Date
* completedComment: String
* assignees: Person[]

Person
* name: String
* role: enum of [member, supervisor]

Team:
* name: String
* supervisor: Person
* members: Person[]

# Commands
* createTask
* publishTask
* assignTask
* completeTask
* cancelTask
* createPerson
* createTeam

# Views
* personal dashboard
* supervisor dashboard
  * team
  * team tasks

# Queries
* getPersonalTasks(query)
  * query: 
    * person.id
    * sort
* getTeamTasks(query)
  * query:
    * team.id
    * person.id
    * status
* getTeamMembers(team.id)