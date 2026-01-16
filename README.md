# VOLUNITY - A VOLUNTEER MANAGEMENT SYSTEM
A comprehensive application for managing volunteers and events, built with Java Swing following MVC architecture.
<img width="2559" height="1528" alt="image" src="https://github.com/user-attachments/assets/234a61f6-34fa-40ab-a8d9-46f56db7ea51" />

## Overview
VolUnity is a volunteer management system designed to streamline the process of volunteer registration, approval, and event management for non-profit organizations. The system provides separate interfaces for administrators and volunteers, with comprehensive CRUD operations, advanced search and sort capabilities, and an intuitive user interface.

### Key Highlights
- MVC Architecture
- Multiple Sorting Algorithms
- Search Functionality
- Undo Functionality
- Queue Based Approval
- Modern UI

## Features
- Analytics Summary: High-level statistics for total volunteers and event counts.
- Activity Log: Real-time log of recent actions with built-in undo functionality.
- Registration Queue: Manage pending sign-ups with a streamlined approve/decline system.
- Advanced Lookup: Search by name, email, or phone with alphabetical sorting.
- Data Organization: Automated sorting (A-Z/Z-A) for efficient database browsing.
- Full CRUD Lifecycle: Complete tools to create, read, update, and delete events.
- Detail Analytics: Automatic duration calculation and date-based sorting.

## Tech Stack
### Core Technologies
- | Technology | Purpose |
- | Java 24.0.2 | Primary Programming Language |
- | Swing | GUI Framework |
- | Apache Netbeans IDE 27 | IDE for development |
- | Java Collections | L;inkedList, ArrayList, Stack, Queue for Data Structures |

### Design Tools
- | Tool | Purpose |
- | Draw.io | System Architecture Diagramns |
- | Balsamic Wireframes | Wireframe Design |
- |Cnava | Logo and UI Bdesign |
- |Microsoft Word | Documentation |

## Package Structure
src/
├── Model/
│   ├── User.java              # User authentication model
│   ├── Volunteer.java         # Volunteer data model
│   ├── Event.java            # Event data model
│   ├── Action.java           # Undo action model
│   ├── DataManager.java      # Centralized data storage
│   └── ValidationUtil.java   # Input validation utilities
│
├── View/
│   ├── LogInFrame.java       # Login interface
│   ├── AdminDashboard.java   # Main admin interface
│   ├── VolunteerRegistrationFrame.java
│   ├── EventAddDialog.java   # Add/Edit event dialog
│   ├── EventDetailsDialog.java
│   ├── VolunteerDetailsDialog.java
│   └── CalendarPanel.java    # Custom calendar widget
│
└── Controller/
    ├── LoginController.java
    ├── AdminController.java
    ├── VolunteerCRUDController.java
    ├── EventCRUDController.java
    ├── ActionStackController.java
    ├── InsertionSort.java    # Sorting algorithm
    ├── MergeSort.java        # Sorting algorithm
    ├── SelectionSort.java    # Sorting algorithm
    ├── LinearSearch.java     # Search algorithm
    └── BinarySearch.java     # Search algorithm

## Installation
### Prerequisites
* Java Development Kit (JDK) 11 or higher
  - [Download JDK](https://www.oracle.com/java/technologies/downloads/)
* Apache NetBeans 12.0+ (recommended) or any Java IDE
  - [Download NetBeans](https://netbeans.apache.org/front/main/download/index.html)
* Git (for cloning the Repository)
  - [Download Git](https://git-scm.com/downloads)
 
### Clone the Repository
This project uses the master branch (not main)

Clone the repository
git clone https://github.com/yourusername/volunity.git

Navigate to project directory
cd volunity

Switch to master branch (if not already there)
git checkout master

### Run with NetBeans
- Open NetBeans IDE
- File → Open Project
- Navigate to the cloned volunity folder
- Select the project and click Open Project
- Right-click on the project → Clean and Build
- Right-click on the project → Run


    
