
// standard library imports
use std::rand;
use std::task::try_future;

// main function
fn main(){

	let secs = 100_000;
	let millis = secs * 1000;

	let case_ii = try_future(
		proc(){ sim_ii( millis)});
	let case_iii = try_future(
		proc(){ sim_iii( millis)});

	let case_ii = case_ii.unwrap().ok().unwrap();
	let result = case_ii as f32 / secs as f32;
	println!("case ii result: {:.2f}", result);

	let case_iii = case_iii.unwrap().ok().unwrap();
	let result = case_iii as f32 / secs as f32;
	println!("case iii result: {:.2f}", result);}

// classes
enum State {
	S00,
	S01, S02, S03,
	S11, S12, S13,
}

/// simulates case ii, returning a guess at the number of requests served in the given amount of time
fn sim_ii( time : i32) -> u32 {
	let mut state = S00;
	let mut time = time;
	let mut result = 0;
	while time > 0 {
		let rand = rand::random::<f32>();
		match state {
			S00 => {
				//both hit
				if rand < 0.64 {
					state = S00;
					time -= 10;
					result += 2;}
				//one hits, one misses
				else if rand < 0.96 {
					state = S01;
					time -= 10;
					result += 1;}
				//both miss
				else {
					state = S11;
					time -= 10;
					result += 0;}}
			S01 => {
				//ready thread hits
				if rand < 0.8 {
					state = S02;
					time -= 5;
					result += 1;}
				//ready thread misses
				else {
					state = S12;
					time -= 5;
					result += 0;}}
			S02 => {
				//ready thread hits
				if rand < 0.8 {
					state = S03;
					time -= 5;
					result += 1;}
				//ready thread misses
				else {
					state = S13;
					time -= 5;
					result += 0;}}
			S03 => {
				//ready thread hits
				if rand < 0.8 {
					state = S00;
					time -= 5;
					result += 2;}
				//ready thread misses
				else {
					state = S01;
					time -= 5;
					result += 1;}}
			S11 => {
				state = S01;
				time -= 15;
				result += 1;}
			S12 => {
				state = S01;
				time -= 10;
				result += 1;}
			S13 => {
				state = S01;
				time -= 5;
				result += 1;}}}
	return result;}

/// simulates case iii, returning a guess at the number of requests served in the given amount of time
fn sim_iii( time : i32) -> u32 {
	let mut state = S00;
	let mut time = time;
	let mut result = 0;
	while time > 0 {
		let rand = rand::random::<f32>();
		match state {
			S00 => {
				//both hit
				if rand < 0.64 {
					state = S00;
					time -= 5;
					result += 2;}
				//one hits, one misses
				else if rand < 0.96 {
					state = S01;
					time -= 5;
					result += 1;}
				//both miss
				else {
					state = S11;
					time -= 5;
					result += 0;}}
			S01 => {
				//ready thread hits
				if rand < 0.8 {
					state = S02;
					time -= 5;
					result += 1;}
				//ready thread misses
				else {
					state = S12;
					time -= 5;
					result += 0;}}
			S02 => {
				//ready thread hits
				if rand < 0.8 {
					state = S03;
					time -= 5;
					result += 1;}
				//ready thread misses
				else {
					state = S13;
					time -= 5;
					result += 0;}}
			S03 => {
				//ready thread hits
				if rand < 0.8 {
					state = S00;
					time -= 5;
					result += 2;}
				//ready thread misses
				else {
					state = S01;
					time -= 5;
					result += 1;}}
			S11 => {
				state = S01;
				time -= 15;
				result += 1;}
			S12 => {
				state = S01;
				time -= 10;
				result += 1;}
			S13 => {
				state = S01;
				time -= 5;
				result += 1;}}}
	return result;}

