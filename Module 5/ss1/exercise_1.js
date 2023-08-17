let courses = [ 
  { 
    id: 1, 
    title: "ReactJS Tutorial", 
    rating: 4.2, 
  }, 
  { 
    id: 2, 
    title: "Angular Tutorial", 
    rating: 2.5, 
  }, 
  { 
    id: 3, 
    title: "VueJS Tutorial", 
    rating: 3.8, 
  }, 
  { 
    id: 4, 
    title: "Java Tutorial", 
    rating: 4, 
  }, 
  { 
    id: 5, 
    title: "JavaScript Tutorial", 
    rating: 3.5, 
  }, 
];

let addedCourses = [ 
  { 
    id: 6, 
    title: "PHP Tutorial", 
    rating: 3, 
  }, 
  { 
    id: 7, 
    title: "C# Tutorial", 
    rating: 2, 
  }, 
  { 
    id: 8, 
    title: "Docker Tutorial", 
    rating: 3.8, 
  } 
]; 

let hightRatingCourse = courses.filter((course) => course.rating >= 4);

console.log(hightRatingCourse);

let lowRatingCourse = courses.filter((course) => course.rating < 4);
console.log(lowRatingCourse);

// Cách 1
let arr = lowRatingCourse.map(element=> element.id + "-" + element.title + "-" + element.rating);
console.log(arr);

// Cách 2
// let courseArray = [];

// function transferCourse(lowRatingCourse,courseArray) {
//   lowRatingCourse.forEach(element => {
//     let temp = element.id + "-" +element.title +"-" +element.rating;
//     courseArray.push(temp);
//   });
//   return courseArray;
// }

// let newCourseList = transferCourse(lowRatingCourse,courseArray);
// console.log(newCourseList);

function concatArray(courses,addedCourses) {
  let combineArray = [...courses,...addedCourses];
  return combineArray;
}

let combineArray = concatArray(courses,addedCourses)
console.log(combineArray);


