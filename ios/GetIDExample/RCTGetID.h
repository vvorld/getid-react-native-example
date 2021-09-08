//
//  RCTGetID.h
//  RNExample
//
//  Created by Mikhail Akopov on 16.12.2020.
//

#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#import <UIKit/UIKit.h>
#import "GetIDExample-Swift.h"

@interface RCTGetID : RCTEventEmitter <RCTBridgeModule, GetIDSwiftWrapperDelegate>
@property (nonatomic, strong) GetIDSwiftWrapper *getIDSwiftWrapper;
@end
